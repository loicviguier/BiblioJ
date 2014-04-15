<%@ page import="biblioj.TypeDocument" %>



<div class="fieldcontain ${hasErrors(bean: typeDocumentInstance, field: 'intitul', 'error')} required">
	<label for="intitul">
		<g:message code="typeDocument.intitul.label" default="Intitul" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="intitul" required="" value="${typeDocumentInstance?.intitul}"/>
</div>

