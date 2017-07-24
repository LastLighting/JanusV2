<#import "/spring.ftl" as spring/>

<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Личный кабинет сотрудника</title>
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
<#if currentUser?? && currentUser.role == "EMPLOYEE">
<div class="center section">
    <div class="center-block row">
        <div class="col s12">
            <div class="col s5 m5">
                <a href="/docs/0">
                    Заявки
                    <img src="/resources/images/processbids.png" class="responsive-img" alt=""/>
                </a>
            </div>
            <div class="col s5 m5">
                <a href="/docs/accepted/page/0">
                    Принятые заявки
                    <img src="/resources/images/okbids.png" class="responsive-img" alt=""/>
                </a>
            </div>
        </div>
        <div class="col s12">
            <div class="col s5 m5">
                <a href="/docs/vet/doc/page/0">
                    Ветеринарные свидетельства
                    <img src="/resources/images/sertifacateR.png" class="responsive-img" alt=""/>
                </a>
            </div>
            <div class="col s5 m5">
                <a href="/docs/vet/sert/page/0">
                    Ветеринарные сертификаты
                    <img src="/resources/images/sertifacateF.png" class="responsive-img" alt=""/>
                </a>
            </div>
        </div>
    </div>
</div>
</#if>
</body>
</html>