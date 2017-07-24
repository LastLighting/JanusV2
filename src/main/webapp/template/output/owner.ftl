<div class="row">
    <div class="input-field col s6">
        <label>Серия и номер паспорта</label>
        <br/>
        <p>${owner.documentNumber!""}</p>
    </div>
    <div class="input-field col s6">
        <label>Имя </label>
        <br/>
        <p>${owner.firstName!""}</p>
    </div>
</div>

<div class="row">
    <div class="input-field col s6">
        <label>Фамилия</label>
        <br/>
        <p>${owner.lastName!""}</p>
    </div>
    <div class="input-field col s6">
        <label>Отчество</label>
        <br/>
        <p>${owner.middleName!""}</p>
    </div>
</div>

<div class="row">
    <div class="input-field col s6">
        <label>Номер телефона</label>
        <br/>
        <p>${owner.phoneNumber!""}</p>
    </div>
    <div class="input-field col s6">
        <label>Дата рождения</label>
        <br/>
        <p>${(owner.birthdate?string("dd-MM-yyyy"))!""}</p>
    </div>
</div>
<div class="row">
    <div class="input-field col s12">
        <label>Адрес</label>
        <br/>
        <p>${owner.address!""}</p>
    </div>
</div>
