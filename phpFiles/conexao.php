<?php
header('Content-type: text/html; charset=UTF-8; application/json');

//Fazendo conexão com o banco.
$host = "sql112.epizy.com";
$user="epiz_23848714";
$pass="rayanne22";
$banco = "epiz_23848714_bdrolenoifapp";
$conexao = mysqli_connect($host,$user,$pass,$banco) or die(mysqli_error());
mysqli_select_db($conexao,$banco) or die(mysqli_error());

//TODO: verificar se é necessario session_start para manter usuario conectado no app tambem
?>