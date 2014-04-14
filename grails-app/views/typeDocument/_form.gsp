<%@ page import="biblioj.TypeDocument" %>



<div class="fieldcontain ${hasErrors(bean: typeDocumentInstance, field: 'inutile', 'error')} required">
	<label for="inutile">
		<g:message code="typeDocument.inutile.label" default="Inutile" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="inutile" required="" value="${typeDocumentInstance?.inutile}"/>
</div>

