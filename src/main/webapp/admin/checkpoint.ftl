<#-- @ftlvariable name="form" type="topprogersgroup.entity.UserCreateForm" -->
<#import "/spring.ftl" as spring>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Создание ПКВП</title>
    <link rel="stylesheet" type="text/css" href='/resources/materialize/css/materialize.css'/>
    <link rel="stylesheet" type="text/css" href='/resources/css/style_child.css'/>

    <script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" rel="script" src="/resources/materialize/js/materialize.js"></script>
</head>
<body>
<div class="header-margin">
<#include "/template/navbar.ftl"/>
</div>
<form role="form" name="form" action="" method="post">
    <div class="row main_block center-block">
        <fieldset class="card table">
            <div class="col s12">
            <input type="hidden" name="id" id="id" value="${checkPoint.id!0}"/>
                <div class="col s12 m6">
                    <label for="cpName">Наименование учреждения</label>
                    <input type="text" name="cpName" id="cpName" value="${checkPoint.cpName!""}" required
                           autofocus/>
                </div>
                <div class="col s12 m6">
                    <label for="address">Адрес учереждения</label>
                    <input type="text" name="address" id="address" value="${checkPoint.address!""}" required/>
                </div>
            </div>
            <div class="col s12">
                <div class="col s12 m6">
                    <label for="phonenumber">Номер телефона</label>
                    <input type="text" name="phoneNumber" id="phoneNumber" value="${checkPoint.phoneNumber!""}"
                           required/><#--placeholder="(XXX)-XXX-XXXX" pattern="(XXX)-XXX-XXXX"-->
                </div>
            </div>
            <div class="btn-block col s12 m5">
                <button type="submit" class="btn waves-effect waves-light">Добавить</button>
            </div>
        </fieldset>
    </div>
</form>
</body>
</html>