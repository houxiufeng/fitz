package com.dexcoder.assistant.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.CollectionUtils;

import com.dexcoder.assistant.utils.ClassUtils;
import com.dexcoder.assistant.utils.NameUtils;

/**
 * jdbc操作dao
 *
 * Created by liyd on 3/3/15.
 */
public class JdbcDaoImpl implements JdbcDao {

    /** spring jdbcTemplate 对象 */
    protected JdbcOperations jdbcTemplate;

    /** 名称处理器，为空按默认执行 */
    protected NameHandler    nameHandler;

    /** rowMapper，为空按默认执行 */
    protected String         rowMapperClass;

    /** 数据库方言 */
    protected String         dialect;
    
    private static Logger LOG = LoggerFactory.getLogger(JdbcDaoImpl.class);

    /**
     * 插入数据
     *
     * @param entity the entity
     * @param criteria the criteria
     * @return long long
     */
    private int insert(Object entity, Criteria criteria) {
        Class<?> entityClass = SqlAssembleUtils.getEntityClass(entity, criteria);
        NameHandler handler = this.getNameHandler();
        String pkValue = handler.getPKValue(entityClass, this.dialect);
        if (StringUtils.isNotBlank(pkValue)) {
            String primaryName = handler.getPKName(entityClass);
            if (criteria == null) {
                criteria = Criteria.create(entityClass);
            }
            criteria.setPKValueName(NameUtils.getCamelName(primaryName), pkValue);
        }
        final BoundSql boundSql = SqlAssembleUtils.buildInsertSql(entity, criteria,
            this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(boundSql.getSql(),
                    new String[] { boundSql.getPrimaryKey() });
                int index = 0;
                for (Object param : boundSql.getParams()) {
                    index++;
                    ps.setObject(index, param);
                }
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public int insert(Object entity) {
        return this.insert(entity, null);
    }

    @Override
    public int insert(Criteria criteria) {
        return this.insert(null, criteria);
    }

    @Override
    public void save(Object entity) {
        final BoundSql boundSql = SqlAssembleUtils.buildInsertSql(entity, null,
            this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        jdbcTemplate.update(boundSql.getSql(), boundSql.getParams().toArray());
    }

    @Override
    public void save(Criteria criteria) {
        final BoundSql boundSql = SqlAssembleUtils.buildInsertSql(null, criteria,
            this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        jdbcTemplate.update(boundSql.getSql(), boundSql.getParams().toArray());
    }

    @Override
    public void update(Criteria criteria) {
        BoundSql boundSql = SqlAssembleUtils.buildUpdateSql(null, criteria, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        jdbcTemplate.update(boundSql.getSql(), boundSql.getParams().toArray());
    }

    @Override
    public void update(Object entity) {
        BoundSql boundSql = SqlAssembleUtils.buildUpdateSql(entity, null, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        jdbcTemplate.update(boundSql.getSql(), boundSql.getParams().toArray());
    }

    @Override
    public void delete(Criteria criteria) {
        BoundSql boundSql = SqlAssembleUtils.buildDeleteSql(null, criteria, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        jdbcTemplate.update(boundSql.getSql(), boundSql.getParams().toArray());
    }

    @Override
    public void delete(Object entity) {
        BoundSql boundSql = SqlAssembleUtils.buildDeleteSql(entity, null, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        jdbcTemplate.update(boundSql.getSql(), boundSql.getParams().toArray());
    }

    @Override
    public void delete(Class<?> clazz, int id) {
        BoundSql boundSql = SqlAssembleUtils.buildDeleteSql(clazz, id, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        jdbcTemplate.update(boundSql.getSql(), boundSql.getParams().toArray());
    }

    @Override
    public void deleteAll(Class<?> clazz) {
        String tableName = this.getNameHandler().getTableName(clazz);
        String sql = "TRUNCATE TABLE " + tableName;
        jdbcTemplate.execute(sql);
        LOG.info("SQL:{}", sql);
    }

    @Override
    public <T> List<T> queryList(Criteria criteria) {
        BoundSql boundSql = SqlAssembleUtils.buildListSql(null, criteria, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        List<?> list = jdbcTemplate.query(boundSql.getSql(), boundSql.getParams().toArray(),
            this.getRowMapper(criteria.getEntityClass()));
        return (List<T>) list;
    }

    @Override
    public <T> List<T> queryList(T entity) {
        BoundSql boundSql = SqlAssembleUtils.buildListSql(entity, null, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        List<?> list = jdbcTemplate.query(boundSql.getSql(), boundSql.getParams().toArray(),
            this.getRowMapper(entity.getClass()));
        return (List<T>) list;
    }

    @Override
    public <T> List<T> queryList(T entity, Criteria criteria) {
        BoundSql boundSql = SqlAssembleUtils.buildListSql(entity, criteria, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        List<?> list = jdbcTemplate.query(boundSql.getSql(), boundSql.getParams().toArray(),
            this.getRowMapper(entity.getClass()));
        return (List<T>) list;
    }

    @Override
    public int queryCount(Object entity, Criteria criteria) {
        BoundSql boundSql = SqlAssembleUtils.buildCountSql(entity, criteria, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        return jdbcTemplate.queryForInt(boundSql.getSql(), boundSql.getParams().toArray());
    }

    @Override
    public int queryCount(Object entity) {
        BoundSql boundSql = SqlAssembleUtils.buildCountSql(entity, null, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        return jdbcTemplate.queryForInt(boundSql.getSql(), boundSql.getParams().toArray());
    }

    @Override
    public int queryCount(Criteria criteria) {
        BoundSql boundSql = SqlAssembleUtils.buildCountSql(null, criteria, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        return jdbcTemplate.queryForInt(boundSql.getSql(), boundSql.getParams().toArray());
    }

    @Override
    public <T> T get(Class<T> clazz, int id) {
        BoundSql boundSql = SqlAssembleUtils.buildByIdSql(clazz, id, null, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());

        //采用list方式查询，当记录不存在时返回null而不会抛出异常
        List<T> list = jdbcTemplate.query(boundSql.getSql(), this.getRowMapper(clazz), id);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.iterator().next();
    }

    @Override
    public <T> T get(Criteria criteria, int id) {
        BoundSql boundSql = SqlAssembleUtils
            .buildByIdSql(null, id, criteria, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());

        //采用list方式查询，当记录不存在时返回null而不会抛出异常
        List<T> list = (List<T>) jdbcTemplate.query(boundSql.getSql(),
            this.getRowMapper(criteria.getEntityClass()), id);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.iterator().next();
    }

    @Override
    public <T> T querySingleResult(T entity) {
        BoundSql boundSql = SqlAssembleUtils.buildQuerySql(entity, null, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());

        //采用list方式查询，当记录不存在时返回null而不会抛出异常
        List<?> list = jdbcTemplate.query(boundSql.getSql(), boundSql.getParams().toArray(),
            this.getRowMapper(entity.getClass()));
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return (T) list.iterator().next();
    }

    @Override
    public <T> T querySingleResult(Criteria criteria) {
        BoundSql boundSql = SqlAssembleUtils.buildQuerySql(null, criteria, this.getNameHandler());
        LOG.info("SQL:{}, PARAMS:{}", boundSql.getSql(), boundSql.getParams().toString());
        //采用list方式查询，当记录不存在时返回null而不会抛出异常
        List<?> list = jdbcTemplate.query(boundSql.getSql(), boundSql.getParams().toArray(),
            this.getRowMapper(criteria.getEntityClass()));
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return (T) list.iterator().next();
    }

    @Override
    public byte[] getBlobValue(Class<?> clazz, String fieldName, int id) {
        String tableName = nameHandler.getTableName(clazz);
        String primaryName = nameHandler.getPKName(clazz);
        String columnName = nameHandler.getColumnName(fieldName);
        String tmp_sql = "select t.%s from %s t where t.%s = ?";
        String sql = String.format(tmp_sql, columnName, tableName, primaryName);
        LOG.info("SQL:{}, PARAMS:{}", sql, id);
        return jdbcTemplate.query(sql, new Object[] { id }, new ResultSetExtractor<byte[]>() {
            @Override
            public byte[] extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    return rs.getBytes(1);
                }
                return null;
            }
        });
    }
    
    @Override
    public <T> List<T> querySql(Class<T> clazz, String sql, Object[] params) {
        List<T> list = jdbcTemplate.query(sql, params,this.getRowMapper(clazz));
        return list;
    }

    /**
     * 获取rowMapper对象
     *
     * @param clazz
     * @return
     */
    protected <T> RowMapper<T> getRowMapper(Class<T> clazz) {

        if (StringUtils.isBlank(rowMapperClass)) {
            return BeanPropertyRowMapper.newInstance(clazz);
        } else {
            return (RowMapper<T>) ClassUtils.newInstance(rowMapperClass);
        }
    }

    /**
     * 获取名称处理器
     *
     * @return
     */
    protected NameHandler getNameHandler() {

        if (this.nameHandler == null) {
            this.nameHandler = new DefaultNameHandler();
        }
        return this.nameHandler;
    }

    public void setJdbcTemplate(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setNameHandler(NameHandler nameHandler) {
        this.nameHandler = nameHandler;
    }

    public void setRowMapperClass(String rowMapperClass) {
        this.rowMapperClass = rowMapperClass;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }


}
