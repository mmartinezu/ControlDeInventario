<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Headers: Origin, X-Requested-With, Content-Type, Accept, Authorization');
header('Content-Type: application/json');
header('Access-Control-Allow-Methods: POST, GET, OPTIONS');
include 'conexion.php';

$funcionario = $_REQUEST['funcionario'];

$sqlSelect = "SELECT * FROM activos where ID_FUN_PER = '$funcionario'";
//Ejecuta el query
$respuesta = $conn->query($sqlSelect);
$result = array();
if ($respuesta->num_rows > 0){
    //Recorre cada fila
    while ($filaActivo = $respuesta->fetch_assoc()){
        //Guarda cada fila en una posicion del array
        array_push($result, $filaActivo);
    }
}else{
    $result = "No hay activos";
}
echo json_encode($result, JSON_FORCE_OBJECT);
?>