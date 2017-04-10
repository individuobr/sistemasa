<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadê Meu Peso</title>
<link rel="stylesheet" href="/sistema/resources/css/reset.css">
<link rel="stylesheet" href="/sistema/resources/css/style_Page.css">
</head>
<body>
	<div class="site">
		<header class="site__header">
		    <div class="header_logo">
			<img src="/sistema/resources/imagens/logo.png" class="logo">
			</div>
			<nav id="nav" role="navigation">
				<ul class="menu clearfix">
					<li><a href="/">Home</a></li>
					<li><a href="/" aria-haspopup="true"> <span>Produtos</span>
					</a>
						<ul>
							<li><a href="/">Sucos</a></li>
							<li><a href="/">Sopas</a></li>
							<li><a href="/">Marmitas Fitnes</a></li>
						</ul></li>
					<li><a href="/" aria-haspopup="true"> <span>Empresa</span>
					</a>
						<ul>
							<li><a href="/">Sobre Nós</a></li>
						</ul></li>
					<li><a href="/">Contato</a></li>
				</ul>
			</nav>
			<script>
				$(function() {
					$('#nav li:has(ul)').doubleTapToGo();
				});
			</script>
		</header>
		
		<main class="clearfix"> <!--site__main nome de fillho, site-main nome de pai, Clearfix quebrar o Float-->
		<div class="conteudo">
		<figure >
			<img src="resources/imagens/img.jpg" class="highlight__image">
			
		</figure>
		</div>
		</main>
		
		<footer class="site__footer site-footer clearfix">
			<p class="site-footer__copyright">&copy; 2016 - Cadê Meu Peso -
				Todos os Direitos Reservados</p>
			<ul class="site-footer__social social">
				<li class="social__item social__item--fb"><a href="--#">Facebook</a></li>
				<li class="social__item social__item--tw"><a href="#">Twitter</a></li>
				<li class="social__item social__item--gp"><a href="#">Google+</a></li>
			</ul>
		</footer>

	</div>

</body>
</html>
