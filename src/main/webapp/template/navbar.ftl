<#import "/spring.ftl" as spring/>
<!-- Dropdown Structure -->
<script>
    $(document).ready(function){
        $(".dropdown-button").dropdown();
    }
</script>

<ul id="dropdownView" class="dropdown-content">
    <li><a href="/admin/vet/list/normal">Стисок ГосВетСлуб</a></li>
    <li><a href="/admin/vet/list/del">Удаленных ГосВетСлужб</a></li>
    <li class="divider"></li>
    <li><a href="/admin/checkpoint/list/normal">Список ПКВП</a></li>
    <li><a href="/admin/checkpoint/list/del">Удаленных ПКВП</a></li>
</ul>

<nav class="nav header-color">
    <ul id="nav">
        <ul id="nav" class="left">
            <li><a href="/home">Янус</a></li>
        <#if currentUser??>
            <#if currentUser.role == "ADMIN">
                <li><a href="/admin/create">Добавить пользователя</a></li>
                <li><a href="/admin/checkpoint/create">Добавить ПКВП</a></li>
                <li><a href="/admin/vet/create">Добавить ГосВетСлужбу</a></li>
            <#elseif currentUser.role == "EMPLOYEE">
                <li><a href="/docs/0">Заявки</a></li>
                <li><a href="/docs/accepted/page/0">Принятые заявки</a></li>
                <li><a href="/docs/vet/doc/page/0">Список ветеринарных свидетельств</a></li>
                <li><a href="/docs/vet/sert/page/0">Список ветеринарных сертификатов</a></li>
            <#elseif currentUser.role == "PET_OWNER">
                <li><a href="/office/pets">Мои питомцы</a></li>
                <li><a href="/office/bids">Мои заявки</a></li>
                <li><a href="/fast/add">Добавить паспорт питомца</a></li>
                <li><a href="/office/bids/create">Заявка на вет. свидетельство</a></li>
            </#if>
        </#if>
        </ul>
        <ul id="nav" class="right">
        <#if !currentUser??>
            <li><a href="/login">Войти</a></li>
        </#if>
        <#if currentUser??>
        <#if currentUser.role == "ADMIN">
            <li><a class="dropdown-button" href="#!" data-activates="dropdownView">Списки объектов</a></li>
            <li><a href="/admin/home">Личный кабинет</a></li>
        <#elseif currentUser.role == "EMPLOYEE">
            <li><a href="/docs/home">Личный кабинет</a></li>
        <#elseif currentUser.role == "PET_OWNER">
            <li><a href="/office/home">Личный кабинет</a></li>
        </#if>
            <li><a href="/logout">Выйти</a></li>
        </#if>
        </ul>
    </ul>
</nav>


