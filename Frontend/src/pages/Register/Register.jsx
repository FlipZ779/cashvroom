// src/pages/Register.jsx
import { useState } from "react";
import api from "../../services/api";

import "./style.css";
import Fiat147 from "../../assets/IconFiat147.png";
import GolQuadrado from "../../assets/IconGolQuadrado.png";
import Logo from "../../assets/CashVroomLogo.png";

function Register() {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await api.post("users/register", formData);
      alert(`Usuário ${response.data.name} cadastrado com sucesso!`);
      setFormData({ name: "", email: "", password: "" });
    } catch (error) {
      alert(error.response?.data || "Erro ao cadastrar");
    }
  };

  return (
    <main className="Register-main">
      <div className="Register-container">
        <img id="logo" src={Logo} alt="Logo" />
        <form onSubmit={handleSubmit}>
          <h1>Cadastro</h1>
          <input
            name="name"
            type="text"
            placeholder="Nome"
            value={formData.name}
            onChange={handleChange}
          />
          <input
            name="email"
            type="email"
            placeholder="E-mail"
            value={formData.email}
            onChange={handleChange}
          />
          <input
            name="password"
            type="password"
            placeholder="Senha"
            value={formData.password}
            onChange={handleChange}
          />
          <button type="submit">Cadastrar</button>
          <p>
            Já possui uma conta? <a href="/login">Clique aqui</a>
          </p>
        </form>
        <img id="fiat" src={Fiat147} alt="Ícone Fiat" />
        <img id="gol" src={GolQuadrado} alt="Ícone Gol" />
      </div>
    </main>
  );
}

export default Register;
