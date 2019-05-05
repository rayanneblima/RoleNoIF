<?php
    include 'conexao.php';

    if($_SERVER['REQUEST_METHOD'] == 'POST'){
        $emailUser = $_POST['emailUser'];
        $senhaUser = $_POST['senhaUser'];
		
		if ($_POST['emailUser'] && $_POST['senhaUser']){
			$resultado = mysqli_query($conexao, "SELECT * FROM tblusers");
			$linhas = mysqli_num_rows($resultado);
			
			while($linhas = mysqli_fetch_array($resultado)){
				if ($linhas['emailUser'] == $emailUser && $linhas['senhaUser'] == $senhaUser) {
					$_SESSION['conectado'] = 1;
					$_SESSION['idUser'] = $linhas['idUser'];  
					$_SESSION['emailUser'] = $linhas['emailUser'];  
					$_SESSION['senhaUser'] = $linhas['senhaUser'];  
				}
			}
		}
		if ($_SESSION["conectado"]){
			$result["code"] = "sucess";
            echo json_encode($result);
		} else{
			$result["code"] = "failed";
            echo json_encode($result);
		}
	}
	
?>