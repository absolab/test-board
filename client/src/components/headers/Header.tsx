import GNB from "./GNB";
import LoginBox from "./LoginBox";
import LogoutBox from "./LogoutBox";

const Header:React.FC<{isLogined:boolean, setIsLogined:(input:boolean)=>void}> = ({isLogined, setIsLogined}) => {

    const setLoginBoxVisiblity = (input:boolean) => { setIsLogined(!input); }
    const setLogoutBoxVisiblity = (input:boolean) => { setIsLogined(input); }

    return (
        <div className="flex p-3 bg-lime-200">
            <GNB></GNB>
            <LoginBox visiblity={!isLogined} setVisiblity={setLoginBoxVisiblity}></LoginBox>
            <LogoutBox visiblity={isLogined} setVisiblity={setLogoutBoxVisiblity}></LogoutBox>
        </div>
    )
}

export default Header;