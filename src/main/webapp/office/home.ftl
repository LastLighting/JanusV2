<#import "/spring.ftl" as spring/>

<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Личный кабинет</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style_child.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/imageDrimmer.css'/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<#include "/template/navbar.ftl">
<#if currentUser?? && currentUser.role == "PET_OWNER">
<div class="center-block section row block-top">
        <div class="row picture-block">
            <div class="col s6 ">
                <a href="/office/pets">
                    Питомцы
                    <img src="/resources/images/pets.png" class="responsive-img" alt=""/>
                </a>
            </div>
            <div id="imgzat" class="col s6 ">
                <a href="/office/bids">
                    Заявки
                    <img src="/resources/images/bids.png" class="responsive-img" alt=""/>
                </a>
            </div>
        </div>
        <div class="row picture-block">
            <div class="col s6 ">
                <a href="/office/bids/create">
                    Создать заявку на Вет Док
                    <img src="/resources/images/bid.png" class="responsive-img" alt=""/>
                </a>
            </div>
            <div class="col s6">
                <a href="/fast/add">
                    Создать паспорт
                    <img src="/resources/images/pass.png" class="responsive-img" alt=""/>
                </a>
            </div>
        </div>
</div>
</#if>
</body>
</html>