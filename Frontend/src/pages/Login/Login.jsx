// src/pages/Register.jsx
import { useState } from 'react';
import api from '../../services/api';

import Fiat147 from '../../assets/IconFiat147.png';
import GolQuadrado from '../../assets/IconGolQuadrado.png';
import Logo from '../../assets/CashVroomLogo.png';

function Login() {
  

  return (
    <div className='container'>
      <img id='logo' src={Logo} alt="Logo" />
      <form >
        <h1>Login</h1>
        
        <input
          name="email"
          type="email"
          placeholder='E-mail'
        
        />
        <input
          name="password"
          type="password"
          placeholder='Senha'
          
        />
        <button type="submit">Logar</button>
        <p>não possui uma conta? <a href="/login">Clique aqui</a></p>
      </form>
      <img id='fiat' src={Fiat147} alt="Ícone Fiat" />
      <img id='gol' src={GolQuadrado} alt="Ícone Gol" />
    </div>
  );
}

export default Login;
