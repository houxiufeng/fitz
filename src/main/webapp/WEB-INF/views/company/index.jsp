<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<input id="_url" type="hidden" value="app/company"/>
<input id="_lastPage" type="hidden" value="${pager.lastPage}"/>
<div class="row-fluid">
    <div class="span12">
        <div class="well grey">
            <div class="well-header">
                <h5>Company Table</h5>
                <!-- <a class="grey btn add" href="javascript:void(0)" style="margin:5px" ><i class="icon-plus"></i>Add</a> -->
                <div class="no-search" style="display:inline; float:right; padding:5px">
                    <select class="chosen" style="width:80px">
                        <option value="20" <c:if test="${pager.itemsPerPage == 20}">selected</c:if>>20</option>
                        <option value="50" <c:if test="${pager.itemsPerPage == 50}">selected</c:if>>50</option>
                        <option value="100" <c:if test="${pager.itemsPerPage == 100}">selected</c:if>>100</option>
                    </select>
                  </div>
                <a class="grey btn add" href="javascript:void(0)" style="float:right; margin:5px" ><i class="icon-plus"></i>Add</a>
            </div>

            <div class="well-content">
              <div class="dataTables_wrapper">
                <table class="table table-striped table-bordered table-hover datatable">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Date</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pager.list}" var="company">
                        <tr>
                            <td>${company.id}</td>
                            <td>${company.name }</td>
                            <td>${company.address }</td>
                            <td>${company.email }</td>
                            <td><fmt:formatDate value="${company.createdAt }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>
                              <a id="${company.id}" class="btn edit" href="javascript:void(0)"><i class="icon-edit"></i></a>
                              <a id="${company.id}" class="btn delete" href="javascript:void(0)"><i class="icon-trash"></i></a>
                            </td>
                        </tr>
                    </c:forEach>    
                       
                    </tbody>
                </table>
                
                <div class="tableFooter">
                  <div>
                    <c:if test="${pager.itemsTotal != 0 }">
                      <div class="dataTables_info" id="DataTables_Table_0_info">Showing ${pager.beginIndex + 1} to ${pager.endIndex} of ${pager.itemsTotal} entries</div>
                    </c:if>
                  </div>
                  <div class="clearfix">
                    <div class="dataTables_paginate paging_bootstrap pagination">
                      <ul>
                        <li class='first <c:if test="${pager.curPage == 1}">disabled</c:if>'><a href="javascript:void(0)">&lt;&lt;</a></li>
                        <li class='prev <c:if test="${pager.curPage == 1}">disabled</c:if>'><a href="javascript:void(0)">&lt;</a></li>
                        <c:forEach items="${slider}" var="page">
                        <li class='item <c:if test="${pager.curPage == page}">active</c:if>'><a href="javascript:void(0)">${page}</a></li>
                        </c:forEach>
                        <li class='next <c:if test="${pager.curPage == pager.lastPage}">disabled</c:if>'><a href="javascript:void(0)">&gt;</a></li>
                        <li class='last <c:if test="${pager.curPage == pager.lastPage}">disabled</c:if>'><a href="javascript:void(0)">&gt;&gt;</a></li>
                      </ul>
                    </div>
                  </div>
                </div>
              
              </div>
            </div>
            
        </div>
    </div>
</div>
