<?php

//Fazendo conexão com o banco.
include 'conexao.php';

//se ja estiver logado, entra na pagina da administracao automaticamente
if (isset($_SESSION['conectado'])) header('Location: index.php');

?>

<!DOCTYPE html>
<html lang="pt">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
				<form class="login100-form validate-form flex-sb flex-w" method = "post" action = "login.php">
					<span class="login100-form-title p-b-51">
						Login				
					</span>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "E-mail obrigatório.">
						<input class="input100" type="email" name="emailUser" placeholder="e-mail">
						<span class="focus-input100"></span>
					</div>
					
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Senha obrigatória.">
						<input class="input100" type="password" name="senhaUser" placeholder="senha">
						<span class="focus-input100"></span>
					</div>
					
					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn">
							entrar
						</button>
					</div>

				</form>

			</div>
		</div>
	</div>

</body>
</html>