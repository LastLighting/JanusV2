<#import "/spring.ftl" as spring/>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Отправленые заявки</title>
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

<div class="header-margin2">
<#--Поиск заявок-->
<#include "/template/search/findbids.ftl">
</div>
<div class="row center-align">
<#if bidList??>
    <table class="striped responsive-table m2">
        <thead>
        <tr>
            <th>Статус</th>
            <th>Количество петомцев</th>
            <th>Время пребывания животного в РФ</th>
            <th>Количество мест под петомцев</th>
            <th>Дата отправления</th>
            <th>Пункт назначения</th>
            <th>Пункт отправления</th>
            <th>Пукты следования</th>
            <th>Въездной БИП в ЕС</th>
            <th>Функуции</th>
        </tr>
        </thead>
        <tbody>
            <#list bidList as bid>
            <tr>
                <td>${bid.status!""}</td>
                <td>${bid.countPet!0}</td>
                <td>${bid.countSeats!0}</td>
                <td>${(bid.departureDate?string("dd/MM/yyyy"))!""}</td>
                <td>${bid.route.destination!""}</td>
                <td>${bid.route.departure!""}</td>
                <td>${bid.route.followingPoints!""}</td>
                <td>${bid.route.BorderInspectionPosts!""}</td>
                <td>
                    <a href="/docs/bid/${bid.id}" class="waves-effect waves-light btn">
                        Принять решение
                    </a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
    <#include "/template/pagination/processbids.ftl"/>
</#if>
</div>

</body>
</html>

