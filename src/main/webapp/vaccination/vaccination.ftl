<#import "/spring.ftl" as spring/>

<html>
<head>
    <title>Add Pet Passport</title>
</head>
<body>

<div>
    <fieldset>
        <legend>Добавить вакцинацию</legend>
        <form name="vaccination" action="" method="POST">
            <div class="row">
                <div class="col s12">
                    <input type="hidden" name="id" value="${vaccination.id}">
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <input type="text" id="seriesOfVaccine" name="seriesOfVaccine" value="${vaccination.seriesOfVaccine!""}" class="validate">
                    <label for="seriesOfVaccine">seriesOfVaccine</label>
                </div>
                <div class="input-field col s6">
                    <input type="text" id="typeOfVaccine" name="typeOfVaccine" value="${vaccination.typeOfVaccine!""}" class="validate">
                    <label for="typeOfVaccine">typeOfVaccine</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="dateOfVaccine" name="dateOfVaccine" value="${vaccination.dateOfVaccine!0}" class="validate">
                    <label for="dateOfVaccine">dateOfVaccine</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s12">
                    <input type="text" id="validUntil" name="validUntil" value="${vaccination.validUntil?string("dd/MM/yyyy")}" class="validate">
                    <label for="validUntil">validUntil</label>
                </div>
            </div>
            <@spring.formHiddenInput "vaccination.id" ""/><br/>
            Дата вакцинации: <@spring.formInput "vaccination.dateOfVaccine" "" "text"/>    <br/>
            Тип вакцины: <@spring.formInput "vaccination.typeOfVaccine" "" "text"/>    <br/>
            Серия вакцины: <@spring.formInput "vaccination.seriesOfVaccine" ""/>    <br/>
            Действительна до: <@spring.formInput "vaccination.validUntil" "" "text"/>    <br/>
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

<#--@Column(name = "dateOfVaccine", nullable = false)-->
<#--@Temporal(value=TemporalType.DATE)-->
<#--private Date dateOfVaccine;-->

<#--@Column(name = "typeOfVaccine", nullable = false)-->
<#--private String typeOfVaccine;-->

<#--@Column(name = "seriesOfVaccine", nullable = false)-->
<#--private String seriesOfVaccine;-->

<#--@Column(name = "validUntil", nullable = false)-->
<#--private Date validUntil;-->
