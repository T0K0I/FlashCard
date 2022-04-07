<%@ taglib uri="/struts-tags" prefix="c" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- nieuw --%>
<link rel="stylesheet" href="./css/inlog.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<%-- oud --%>
<%--<link rel="stylesheet" href="./css/login.css">--%>

<style>
    body{
        background-image: url("./img/snowie.jpg");
        background-size: cover;
    }
</style>


<div class="container" >
    <div class="row inlog" >
        <div class="col-lg-10 col-xl-9 mx-auto">

            <div class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
                <div class="card-img-left d-none d-md-flex">
                    <!-- Background image for card set in CSS! -->
                </div>
                <div id="boxLogin">
                    <div class="card-body p-4 p-sm-5">
                        <h5 class="card-title text-center mb-5 fw-light fs-5">Inloggen</h5>
                        <c:form action="login">

                            <hr class="my-4">



                            <div class="form-floating mb-3">
                                <c:textfield class="form-control" id="floatingInputEmail" name="email" placeholder="name@example.com" />
                                <label for="floatingInputEmail">Email adres</label>
                            </div>

                            <!-- <hr> -->

                            <div class="form-floating mb-3">
                                <c:password type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password"/>
                                <label for="floatingPassword">Wachtwoord</label>
                            </div>



                            <div class="d-grid mb-2">
                                <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase" type="submit">Inloggen</button>
                            </div>

                            <a class="d-block text-center mt-2 small" onclick="showForm(0)" href="#">Nog geen account, Registreer</a>

                            <hr class="my-4">
                        </c:form>
                        </div>
                </div>






<%--2e--%>
                            <div id="boxRegister" style="display: none">
                                <div class="card-body p-4 p-sm-5">
                                    <h5 class="card-title text-center mb-5 fw-light fs-5">registreren</h5>
                                    <c:form action="register">
                                        <hr class="my-4">
                                        <div class="form-floating mb-3">
                                            <c:textfield type="text" class="form-control" id="floatingInputUsername" name="firstname" placeholder="myusername" />
                                            <label for="floatingInputUsername">voor naam</label>
                                        </div>

                                        <div class="form-floating mb-3">
                                            <c:textfield type="email" class="form-control" id="floatingInputEmail" name="email" placeholder="name@example.com"/>
                                            <label for="floatingInputEmail">Email adres</label>
                                        </div>

                                        <hr>

                                        <div class="form-floating mb-3">
                                            <c:password class="form-control" id="floatingPassword" name="password" placeholder="Password"/>
                                            <label for="floatingPassword">Wachtwoord</label>
                                        </div>



                                        <div class="d-grid mb-2">
                                            <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase" type="submit">Registreren</button>
                                        </div>

                                        <a class="d-block text-center mt-2 small"  onclick="showForm(1)" href="#">Al een account, log in</a>

                                        <hr class="my-4">
                                    </c:form>
                                </div>
                            </div>



                </div>
            </div>
        </div>
    </div>
</div>



</body>
<script>

    function showForm(tab) {
        var login = document.getElementById("boxLogin");
        var register = document.getElementById("boxRegister");

        if (tab == 0) {
            register.style.display = 'block';
            login.style.display = 'none';
        } else {
            register.style.display = 'none';
            login.style.display = 'block';
        }
    }


</script>

