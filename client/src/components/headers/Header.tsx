import { useEffect, useState } from "react";
import GNB from "./GNB";
import LoginBox from "./LoginBox";
import LogoutBox from "./LogoutBox";

const Header = () => {

    const [isLogined, setIsLogined] = useState(false);
    useEffect(() => {
        const name = sessionStorage.getItem('login');
        if (name !== null) {
            setIsLogined(true);
        }
    }, [])

    return (
        <div className="flex p-3 bg-lime-200">
            <GNB></GNB>
            <LoginBox isVisible={!isLogined}></LoginBox>
            <LogoutBox isVisible={isLogined}></LogoutBox>
        </div>
    )
}

export default Header;