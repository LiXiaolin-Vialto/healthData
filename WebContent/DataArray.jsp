<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>  
	<json:object>
		<json:array name="value" var="value" items="${value}">
				<json:property name="v" value="${value}"/>
		</json:array>
	</json:object>
	