<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row-fluid">
    <div class="span12">
        <div class="well brown">
            <div class="well-header">
                <h5>User Table</h5>
            </div>

            <div class="well-content">
              <div class="dataTables_wrapper">
                
                <div class="tableHeader">
                  <div class="span6 no-search">
                    <select class="chosen">
                        <option>10</option>
                        <option>20</option>
                        <option>50</option>
                    </select>
                  </div>
                  <div class="span6">
                    <div class="search">
                        <input type="text" class="search-query" placeholder="Search">
                        <a href="#" class="blue btn">Go!</a>
                    </div>
                  </div>
                </div>
                
                <table class="table table-striped table-bordered table-hover datatable">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Email</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${records}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name }</td>
                            <td>${user.age }</td>
                            <td>${user.email }</td>
                            <td>${user.createdAt }</td>
                        </tr>
                    </c:forEach>    
                       
                    </tbody>
                </table>
                
                <div class="tableFooter">
                  <div>
                    <div class="dataTables_info" id="DataTables_Table_0_info">Showing ${begin + 1} to ${end} of ${total} entries</div>
                  </div>
                  <div class="clearfix">
                    <div id="p_user" class="dataTables_paginate paging_bootstrap pagination">
                      <ul>
                        <li class='prev <c:if test="${currentPage == 1}">disabled</c:if>'><a href="javascript:void(0)">Previous</a></li>
                        <c:forEach items="${pages}" var="page">
                        <li class='item <c:if test="${currentPage == page}">active</c:if>'><a href="javascript:void(0)">${page}</a></li>
                        </c:forEach>
                        <li class="next"><a href="javascript:void(0)">Next</a></li>
                      </ul>
                    </div>
                  </div>
                </div>
              
              </div>
            </div>
            
        </div>
    </div>
</div>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script src="${ctx}/js/fitz.js"></script>
