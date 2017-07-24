<#import "/spring.ftl" as spring/>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Список Международных Ветеренарных сетрификатов</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/pgwslider.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style_child.css'/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/office.js"></script>

<#include "/template/navbar.ftl">
<div class="section">
<#if vetSertList??>
    <table class="striped responsive-table">
        <thead>
        <tr>
            <th>Номер сертификата</th>
            <th>Статус</th>
            <th>Дата оформления сертификата</th>
            <th>Цетральный компетентный орган</th>
            <th>Местный компетентный орган</th>
            <th>Место оформления</th>
            <th>Функуции</th>
        </tr>
        </thead>
        <tbody>
            <#list vetSertList as vetSert>
            <tr>
                <td>${vetSert.number!0}</td>
                <td>${vetSert.status!""}</td>
                <td>${(vetSert.issueDate?string("dd/MM/yyyy"))!""}</td>
                <td>${vetSert.centralCompetentAuthority!""}</td>
                <td>${vetSert.localCompetentAuthority!""}</td>
                <td>${vetSert.registrationPlace!""}</td>
                <td>
                    <#if vetSert.status=="CREATED">
                        <a href="/docs/vet/doc/${vetDoc.id}/send" class="waves-effect waves-light btn">
                            Отправить зарубежной стране
                        </a>
                    <#else>
                        <a class="btn disabled">
                            Отправить зарубежной стране
                        </a>
                    </#if>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>

    <#if numberPage?? >
        <#include "/template/pagination/pagvetdoc.ftl"/>
    </#if>
</#if>
</div>

</body>
</html>

