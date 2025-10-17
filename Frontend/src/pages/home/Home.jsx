import "./Home.css";
import Logo from '../../assets/CashVroomLogo.png'

function Home(){
    return(
        <div className="home-container">
            <header>
                <h1 className="welcome">
                    Bem Vindo 
                </h1>

                <div className="logo">
                    <img src={Logo} alt="Logo" />
                </div>
                <div>
                    <ol className="">
                        <li>Logar</li>
                        <li>Cadastrar</li>
                        <li>Ranking</li>
                    </ol>
                </div>
            </header>
            
            <aside>

            </aside>
            <main>
                
                
            </main>
            <footer>

            </footer>
        </div>

    )
}
export default Home