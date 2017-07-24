<#import "/spring.ftl" as spring>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Список удаленных Гос. вет. служб</title>
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style.css'/>

    <script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" rel="script" src="/resources/materialize/js/materialize.js"></script>
</head>
<body>
<#include "/template/navbar.ftl"/>

<#if svServiceList??>
<div class="row">
    <div class="col s9 m6 l5">
        <table class="striped responsive-table">
            <thead>
            <tr>
                <th>Наименование учреждения</th>
                <th>Адрес учереждения</th>
                <th>Востановить</th>
            </tr>
            </thead>
            <tbody>
                <#list svServiceList as svService>
                <tr>
                    <td>${svService.serviceName!""}</td>
                    <td>${svService.address!""}</td>
                    <td>
                        <a href="/admin/vet/list/${svService.id}/restore" class="waves-effect waves-light btn">
                            Востановить
                        </a>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>
</#if>

</body>
</html>