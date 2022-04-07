<script>
    import Sidebar from "./docent/sidebar.svelte";

    import Topbar from "./docent/topbar.svelte";

    import Leerlinglijst from "./docent/leerlinglijst.svelte";

    import Overzicht from "./docent/overzicht.svelte";

    import CardGrid from "./leerling/cardGrid.svelte";

    import Account from "./account/Account.svelte";

    import Spel from "./leerling/spel.svelte";

    import OefenSessie from "./leerling/oefenSessie.svelte";


    let currentView = OefenSessie;

    let viewName = "Dashboard";

    function switchView(viewToPick) {

        switch (viewToPick) {

            case "Dashboard":
                currentView = CardGrid;
                break;

            case "OefenSessie":
                currentView = OefenSessie;
                break;

            case "Oefenen":
                currentView = Spel;
                break;

            case "Leerlinglijst":
                currentView = Leerlinglijst;
                break;

            case "Overzicht":
                currentView = Overzicht;
                break;

            case "Account":
                currentView = Account;
                break;

            default:
                break;
        }

        viewName = viewToPick;

    }

    switchView("Account");

</script>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
        name="viewport"
        content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>OptiFlash</title>

    <!-- Custom fonts for this template-->
    <link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
        integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
        crossorigin="anonymous"
        referrerpolicy="no-referrer"
    />
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet"
    />

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.css" rel="stylesheet" />
</head>

<!-- Page Wrapper -->
<div id="wrapper">
    <Sidebar />

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <Topbar />

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">{viewName}</h1>

                <svelte:component this={currentView}></svelte:component>

            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; OptiFlash</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->
    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up" />
</a>

