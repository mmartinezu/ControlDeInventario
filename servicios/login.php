<?php
if (isset($_REQUEST['usuario']) && isset($_REQUEST['password'])){
    include 'conexion.php';

    $usuario = $_REQUEST['usuario'];
    $password = $_REQUEST['password'];

    $query = "SELECT * FROM USUARIOS WHERE ID_USU = '$usuario' AND CLA_USU = '$password'";
    $resultado = mysqli_query($conn, $query);
    $arreglo = array();
    while($fila = mysqli_fetch_assoc($resultado)){
        array_push($arreglo, $fila);
    }
    echo json_encode($arreglo, JSON_FORCE_OBJECT);
    mysqli_close($conn);
}
?>