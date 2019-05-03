<?php
    if($_SERVER['REQUEST_METHOD'] == 'POST'){
        $nome = $_POST['nome'];
        $email = $_POST['email'];
        $matricula = $_POST['matricula'];
        $telefone = $_POST['telefone'];
        $cidade = $_POST['cidade'];
        $senha = $_POST['senha'];
        $senha = password_hash($senha, PASSWORD_DEFAULT);

        require_once 'conexao.php';
        $sql = "INSERT INTO user(nome, email, matricula, telefone, cidade, senha) VALUES ('$nome', '$email','$matricula','$telefone','$cidade', '$senha')";
        if(mysqli_query($con, $sql)){
            $result["Success"] = "0";
            $result["message"] = "Success";

            echo json_encode($result);
            mysqli_close($con);
        }else {
            $result["Success"] = "1";
            $result["message"] = "Error";

            echo json_encode($result);
            mysqli_close($con);
        }
    }
?>