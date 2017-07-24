<#import "/spring.ftl" as spring/>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Паспорт питомца</title>
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
<script type="text/javascript" rel="script" src="/resources/js/pgwslider.js"></script>

<#include "/template/navbar.ftl">

<div class="section">
<#if bidList??>
    <div class="row center-block">
        <#list bidList as bid>
            <fieldset class="card table">
                <div class="row">
                    <div class="col s12 m6">
                        <p class="flow-text">Статус: ${bid.status!""}</p>
                    </div>
                    <div class="col s12">
                        <div class="col s6">
                            <label class="flow-text"> Количество мест под питомцев:</label>
                            <p class="flow-text">  ${bid.countSeats!0}</p>
                        </div>
                        <div class="col s6">
                            <label class="flow-text"> Дата отправления: </label>
                            <p class="flow-text">  ${(bid.departureDate?string("dd-MM-yyyy"))!""}</p>
                        </div>
                    </div>
                    <div class="col s12">
                        <div class="col s6">
                            <label class="flow-text"> Пункт назначения:</label>
                            <p class="flow-text">  ${bid.route.destination!""}</p>
                        </div>
                        <div class="col s6">
                            <label class="flow-text"> Пукты следования: </label>
                            <p class="flow-text"> ${bid.route.followingPoints!""}</p>
                        </div>
                    </div>
                    <div class="col s12">
                        <div class="col s6">
                            <label class="flow-text"> Пункт отправления: </label>
                            <p class="flow-text">${bid.route.departure!""}</p>
                        </div>
                        <div class="col s6">
                            <label class="flow-text"> Въездной БИП в ЕС: </label>
                            <p class="flow-text">${bid.route.BorderInspectionPosts!""}</p>
                        </div>
                    </div>
                </div>
                <div class="card-action">
                    <div class="row"><a href="/office/bids/${bid.id}/preview">Просмотреть</a></div>
                    <div class="row"><a href="/office/bids/${bid.id}/edit">Редактировать</a></div>
                </div>
            </fieldset>
        </#list>
    </div>
</#if>

</div>

</body>
</html>

