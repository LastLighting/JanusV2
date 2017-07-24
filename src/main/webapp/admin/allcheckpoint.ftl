<#-- @ftlvariable name="form" type="topprogersgroup.entity.UserCreateForm" -->
<#import "/spring.ftl" as spring>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Список ПКВП</title>
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style.css'/>

    <script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" rel="script" src="/resources/materialize/js/materialize.js"></script>
</head>
<body>
<#include "/template/navbar.ftl"/>

<#if checkPointList??>
<table class="striped responsive-table">
    <thead>
    <tr>
        <th>Наименование учреждения</th>
        <th>Адрес учереждения</th>
        <th>Номер телефона</th>
        <th>Редактировать</th>
        <th>Удалить</th>
    </tr>
    </thead>
    <tbody>
        <#list checkPointList as checkPoint>
        <tr>
            <td>${checkPoint.cpName!""}</td>
            <td>${checkPoint.address!""}</td>
            <td>${checkPoint.phoneNumber!""}</td>
            <td>
                <a href="/admin/checkpoint/list/${checkPoint.id}/edit" class="waves-effect waves-light btn">
                    Редактировать
                </a>
            </td>
            <td>
                <a href="/admin/checkpoint/list/${checkPoint.id}/delete"class="waves-effect waves-light btn">
                    Удалить
                </a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
</#if>

</body>
</html>