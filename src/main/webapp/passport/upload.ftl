<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Add Pet Passport</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="/resources/materialize/css/materialize.css" media="screen,projection"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/style.css"/>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

</head>
<body>
<script type="text/javascript" rel="script" src="/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" rel="script" src="/resources/materialize/js/materialize.min.js"></script>


<form name="passport" action="" method="POST">

    <div class="row">
        <div class="input-field col s12">
            <input type="file" id="passportPhoto" name="passportPhoto" value="${passport.passportPhoto!""}"
                   class="validate">
            <label for="passportPhoto">Фото пасспорта</label>
        </div>
    </div>
    <div class="row">
        <button class="btn waves-effect waves-light" type="submit" name="action">Создать
            <i class="material-icons right">send</i>
        </button>


    </div>
        <input type="submit" value="Созда">
</form>
<script>
    function showHideMicrochipTattoo() {
        if ($("#microchipTattoo").is(':checked')) {
            $(".microchipTattooShower").first().show("fast", function showNext() {
                $(this).next(".microchipTattooShower").show("fast", showNext);
            });
        } else {
            $(".microchipTattooShower").hide(1000);
        }
    }
</script>
<script>
    $('.datepicker').pickadate({
        selectMonths: false, // Creates a dropdown to control month
        selectYears: 17 // Creates a dropdown of 15 years to control year
    });
</script>

<script>
    $('.datepicker').formats("dd/mm/yyyy");
</script>

</body>

</html>




<#--@Column(name = "animalType", nullable = false)-->
<#--private String animalType;-->

<#--@Column(name = "name", nullable = false)-->
<#--private String name;-->

<#--//пол-->
<#--@Column(name = "gender", nullable = false)-->
<#--private boolean gender;-->

<#--//порода-->
<#--@Column(name = "breed", nullable = false)-->
<#--private String breed;-->

<#--@Column(name = "color", nullable = false)-->
<#--private String color;-->

<#--//особые приметы-->
<#--@Column(name = "specialFeatures")-->
<#--private String specialFeatures;-->

<#--@Column(name = "dateOfBirth", nullable = false)-->
<#--@Temporal(value=TemporalType.DATE)-->
<#--private Date dateOfBirth;-->

<#--//потомство-->
<#--@Column(name = "offspring")-->
<#--private String offspring;-->

<#--@OneToOne-->
<#--@JoinColumn(name = "owner_id")-->
<#--private Owner owner;-->

<#--//Иммунизация-Дегельминтизация-->
<#--@OneToMany(mappedBy = "passport", cascade = CascadeType.ALL)-->
<#--private List<ImmunizationDeworming> immunizationDeworming;-->

<#--@Column(name = "castrationSterilization")-->
<#--private boolean castrationSterilization;-->

<#--@Column(name = "clinic", nullable = false)-->
<#--private String clinic;-->

<#--@Column(name = "doctor", nullable = false)-->
<#--private String doctor;-->

<#--@Column(name = "microchipTattoo", nullable = false)-->
<#--private boolean microchipTattoo;-->

<#--@Column(name = "numberMicrochipTattoo", nullable = false)-->
<#--private String numberMicrochipTattoo;-->

<#--@Column(name = "dateOfImplantation", nullable = false)-->
<#--@Temporal(value=TemporalType.DATE)-->
<#--private Date dateOfImplantation;-->

<#--@Column(name = "passportPhoto", nullable = false)-->
<#--private String passportPhoto;-->

<#--@OneToMany(mappedBy = "passport", cascade = CascadeType.ALL, orphanRemoval = true)-->
<#--private List<Vaccination> vaccination;-->


<#--<input type="hidden" name="id" value="${passport.id}"/>

<option value="${passport.gender}" selected>М</option>
            <option value="М">М</option>
            <option value="Ж">Ж</option>


              <br/>-->
<#--Кличка: <input type="text" name="name" />    <br/>&lt;#&ndash; value="${passport.name}"          value="${passport.gender}"     &ndash;&gt;-->
<#--animalType <input type="text" name="animalType" value="${passport.animalType!""}"/>    <br/>-->
<#--<input type="text" name="gender" value="${passport.gender?string("yes", "no")}"/>    <br/>-->
<#--Пол: <input type="">-->
<#--Парода:<input type="text" name="breed" value="${passport.breed!""}"/>    <br/>-->
<#--Цвет:<input type="text" name="color" value="${passport.color!""}"/>    <br/>-->
<#--Особые приметы specialFeatures:<input type="text" name="specialFeatures" value="${passport.specialFeatures!""}"/>    <br/>-->
<#--Date Дата рождения:<input type="text" name="dateOfBirth" value="${passport.dateOfBirth?string("dd/MM/yyyy")}"/>    <br/>-->
<#--Потомство:<input type="text" name="offspring" value="${passport.offspring!""}"/>    <br/>-->
<#--&lt;#&ndash;<input type="text" name="owner" value="owner"/>    <br/>&ndash;&gt;-->
<#--&lt;#&ndash;<input type="text" name="immunizationDeworming" value="${passport.breed}"/>    <br/>&ndash;&gt;-->

<#--<#if passport.castrationSterilization??>-->
<#--Кастрация/стрерилизация:<input type="checkbox" name="castrationSterilization" checked="checked"/>    <br/>-->
<#--<#else>-->
<#--Кастрация/стрерилизация:<input type="checkbox" name="castrationSterilization"/>    <br/>-->
<#--</#if>-->
<#--Кастрация/стрерилизация:<input type="checkbox" name="castrationSterilization" checked="checked"/>    <br/>-->
<#--Клиника:<input type="text" name="clinic" value="${passport.clinic!""}" />    <br/>-->
<#--Доктор:<input type="text" name="doctor" value="${passport.doctor!""}"/>    <br/>-->
<#--&lt;#&ndash;Наличие микрочипа/тату:<input type="checkbox" name="microchipTattoo" value="${passport.microchipTattoo!""}"/>    <br/>&ndash;&gt;-->
<#--Номер микрочипа/тату:<input type="text" name="numberMicrochipTattoo" value="${passport.numberMicrochipTattoo!""}"/>    <br/>-->
<#--Дата <input type="text" name="dateOfImplantation" value="${passport.dateOfImplantation?string("dd/MM/yyyy")}"/>    <br/>-->
<#--Фото паспорта:<input type="text" name="passportPhoto" value="${passport.passportPhoto!""}"/>    <br/>-->
<#--&lt;#&ndash;<input type="text" name="vaccination" value="${passport.breed}"/>    <br/>&ndash;&gt;-->
<#--<input type="submit" value="Создать" />-->
