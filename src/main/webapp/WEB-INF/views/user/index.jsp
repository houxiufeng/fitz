<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input id="_url" type="hidden" value="user"/>
<input id="_lastPage" type="hidden" value="${pager.lastPage}"/>
<div class="row-fluid">
    <div class="span12">
        <div class="well light_blue">
            <div class="well-header">
                <h5>User Table</h5>
                <a class="light_blue btn add" href="javascript:void(0)" style="margin:5px" ><i class="icon-plus"></i>Add</a>
                <div class="no-search" style="display:inline; float:right; padding:5px">
                    <select class="chosen" style="width:80px">
                        <option value="20" <c:if test="${pager.itemsPerPage == 20}">selected</c:if>>20</option>
                        <option value="50" <c:if test="${pager.itemsPerPage == 50}">selected</c:if>>50</option>
                        <option value="100" <c:if test="${pager.itemsPerPage == 100}">selected</c:if>>100</option>
                    </select>
                  </div>
            </div>

            <div class="well-content">
              <div class="dataTables_wrapper">
                <table class="table table-striped table-bordered table-hover datatable">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Password</th>
                            <th>Age</th>
                            <th>Email</th>
                            <th>Date</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pager.list}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name }</td>
                            <td>${user.password}</td>
                            <td>${user.age }</td>
                            <td>${user.email }</td>
                            <td>${user.createdAt }</td>
                            <td>
                              <a id="${user.id}" class="btn edit" href="javascript:void(0)"><i class="icon-edit"></i></a>
                              <a id="${user.id}" class="btn delete" href="javascript:void(0)"><i class="icon-trash"></i></a>
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
