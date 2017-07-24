
<#import "/spring.ftl" as spring>

<form name="form" action="doUpload" method="post" enctype="multipart/form-data">
    <fieldset>
        <p>
            <input type="file" name="images" multiple="multiple"/>
            <input type="submit" value="Загрузить картинки">

        </p>
    </fieldset>
</form>


<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>
