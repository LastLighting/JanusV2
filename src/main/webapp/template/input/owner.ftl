<#setting date_format="YYYY/MM/DD">
<script type="text/javascript" rel="script" src="/resources/js/combodate.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/moment.js"></script>
<script type="text/javascript" rel="script" src="/resources/js/owner_validate.js"></script>
<script type="text/javascript" rel="script" src="/webjars/jquery-validation/1.16.0/jquery.validate.js"></script>
<div class="row">
    <div class="input-field col s6">
        <input type="text" name="documentNumber" id="documentNumber"
               value="${owner.documentNumber!""}" maxlength="10">
        <label for="documentNumber">Серия и номер паспорта</label>
    </div>
    <div class="input-field col s6">
        <input type="text" id="firstName" name="firstName" value="${owner.firstName!""}">
        <label for="firstName">Имя</label>
    </div>
</div>

<div class="row">
    <div class="input-field col s6">
        <input type="text" id="lastName" name="lastName" value="${owner.lastName!""}">
        <label for="lastName">Фамилия</label>
    </div>
    <div class="input-field col s6">
        <input type="text" id="middleName" name="middleName" value="${owner.middleName!""}">
        <label for="middleName">Отчество</label>
    </div>
</div>

<div class="row">
    <div class="input-field col s6">
        <br/>
        <input type="text" id="phoneNumber" name="phoneNumber"  maxlength="11"  minlength="11" required pattern="d{11}" value="${owner.phoneNumber!""}">
        <label for="phoneNumber">Номер телефона</label>
    </div>
    <div class="input-field col s6">
        <br/>
            <input type="text" class="date" id="birthdate" name="birthdate" data-format="YYYY/MM/DD" data-template="D MMM YYYY"
                   value="${owner.birthdate!"1996/10/24"?date}">
            <label for="birthdate">День рождения</label>
    </div>
</div>
<div class="row">
    <div class="input-field col s12">
        <input type="text" id="address" name="address" value="${owner.address!""}">
        <label for="address">Адрес</label>
    </div>
</div>

