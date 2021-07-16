<?php
include 'conexion.php';

$sqlSelect = "SELECT * FROM funcionarios";
//Ejecuta el query
$respuesta = $conn->query($sqlSelect);
$result = array();
if ($respuesta->num_rows > 0){
    //Recorre cada fila
    while ($filaFuncionario = $respuesta->fetch_assoc()){
        //Guarda cada fila en una posicion del array
        array_push($result, $filaFuncionario);
    }
}else{
    $result = "No hay funcionarios";
}
echo json_encode($result, JSON_FORCE_OBJECT);
?>