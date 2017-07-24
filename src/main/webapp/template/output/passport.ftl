<div class="row">
    <input type="hidden" name="id" value="${passport.id}">
</div>

<div class="row">
    <div class="input-field col s6">
        <label>Кличка</label>
        <br/>
        <p>${passport.petName!""}</p>
    </div>
    <div class="input-field col s6">
        <label>Тип питомца</label>
        <br/>
        <p>${passport.animalType!""}</p>
    </div>
</div>

<div class="row">
    <div class="input-field col s6">
        <label>Порода</label>
        <br/>
        <p>${passport.breed!""}</p>
    </div>
    <div class="input-field col s6">
        <label>Окрас</label>
        <br/>
        <p>${passport.color!""}</p>
    </div>
</div>


<div class="row">
    <div class="col s3">
        <label>Пол</label>
    <#if passport.gender == true>
        <p>Ж</p>
    <#else>
        <p>М</p>
    </#if>
    </div>
    <div class="col s3">
        <label>Идентификация</label>
    <#if passport.microchipTattoo == true>
        <p>Чип</p>
    <#else>
        <p>Тату</p>
    </#if>
    </div>
    <div class="col s3">
        <label>Кастрация/Стерилизация</label>
        <br/>
        <input type="checkbox" id="castrationSterilization" name="castrationSterilization"
    <#if passport.microchipTattoo == true>
        <p>Да</p>
    <#else>
        <p>Нет</p>
    </#if>
    </div>
</div>

<div class="row">
    <div id="labelDateOfBirth" class="input-field col s3">
        <label>Дата рождения</label>
        <br/>
        <p>${(passport.dateOfBirth?string("dd-MM-yyyy"))!""}</p>
    </div>

    <div class="input-field col s6">
        <label>Номер чипа/тату</label>
        <br/>
        <p>${passport.numberMicrochipTattoo!""}</p>
    </div>
    <div id="labelDateOfImpl" class="input-field col s3">
        <label>Дата чипирования/татуирования</label>
        <br/> <br/>
        <p>${(passport.dateOfImplantation?string("dd/MM/yyyy"))!""}</p>
    </div>
</div>

<div class="row">
    <div class="input-field col s6">
        <label>Клиника</label>
        <br/>
        <p>${passport.clinic!""}</p>
    </div>
    <div class="input-field col s6">
        <label>Доктор</label>
        <br/>
        <p>${passport.doctor!""}</p>
    </div>
</div>

<div class="row">
    <div class="input-field col s12">
        <label>Потомство</label>
        <br/>
        <p>${passport.offspring!""}</p>
    </div>
</div>

<div class="row">
    <div class="input-field col s12">
        <label>Специальные признаки</label>
        <br/>
        <p>${passport.specialFeatures!""}</p>
    </div>
</div>