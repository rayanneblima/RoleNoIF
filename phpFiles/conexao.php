<?php
header('Content-type: text/html; charset=UTF-8; application/json');
//Fazendo conexão com o banco.
$host = "localhost";
$user="id9517233_rayanne";
$pass="rayanne22";
$banco = "id9517233_bd_rolenoifapp";
$conexao = mysqli_connect($host,$user,$pass,$banco) or die(mysqli_error());
mysqli_select_db($conexao,$banco) or die(mysqli_error());
session_start();

//TODO: verificar se é necessario session_start para manter usuario conectado no app tambem
?>
