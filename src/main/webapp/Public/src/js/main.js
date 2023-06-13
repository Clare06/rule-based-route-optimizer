const body = document.getElementById('body-pd');
  const currentUrl = window.location.pathname;

  if (currentUrl === '/login') {
    body.style.backgroundColor = 'white';
  } else  {
    body.style.backgroundColor = '#18202A';
  }

