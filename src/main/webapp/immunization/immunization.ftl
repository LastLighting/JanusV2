<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Add Pet Passport</title>
</head>
<body>
<#if errorMessage??>
<div style="color:red;font-style:italic;">
${errorMessage}
</div>
</#if>

<div>
    <fieldset>
        <legend>Добавить Иммунизация/Паразиты</legend>
        <form name="immunization" action="" method="POST">
            <div class="row">
                <div class="col s12">
                    <input type="hidden" name="id" value="${immunization.id}">
                </div>
                <div class="input-field col s6">
                    <input type="text" id="immunizationDeworming" name="immunizationDeworming" value="${immunizationDeworming.diseases!""}" class="validate">
                    <label for="immunizationDeworming">immunizationDeworming</label>
                </div>
                <div class="input-field col s6">
                    <input type="text" id="drug" name="drug" value="${immunization.drug!""}" class="validate">
                    <label for="drug">drug</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="name" name="name" value="${immunization.name!0}" class="validate">
                    <label for="name">name</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="date" name="date" value="${immunization.date?string("dd/MM/yyyy")}" class="validate">
                    <label for="date">date</label>
                </div>
            </div>
            <@spring.formHiddenInput "immunization.id" ""/>    <br/>
            Иммунизация/паразиты: <@spring.formCheckbox "immunization.immunizationDeworming" ""/>    <br/>
            Дата: <@spring.formInput "immunization.date" "" "text"/>    <br/>
            Название: <@spring.formInput "immunization.name" "" "text"/>    <br/>
            Препорат: <@spring.formInput "immunization.drug" ""/>    <br/>
            <input type="submit" value="Create" />
        </form>
    </fieldset>
</div>

</body>

</html>


<#--@Id-->
<#--@GeneratedValue(strategy= GenerationType.IDENTITY)-->
<#--@Column(name = "id", unique = true, nullable = false)-->
<#--private int id;-->

<#--@Column(name = "immunizationDeworming", nullable = false)-->
<#--private boolean immunizationDeworming;-->

<#--@Column(name = "date", nullable = false)-->
<#--@Temporal(value=TemporalType.DATE)-->
<#--private Date date;-->

<#--@Column(name = "name", nullable = false)-->
<#--private String name;-->

<#--@Column(name = "drug", nullable = false)-->
<#--private String drug;-->

<#--@ManyToOne-->
<#--@JoinColumn(name = "id_passport")-->
<#--private Passport passport;-->