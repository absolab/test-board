import { useEffect, useState } from "react";
import GNB from "./GNB";
import LoginBox from "./LoginBox";

const Header = () => {

    const [isLogined, setIsLogined] = useState(false);
    // useEffect(() => {
    //     setIsLogined(true);
    // }, [])

    return (
        <div className="flex p-3 bg-lime-200">
            <GNB></GNB>
            <LoginBox isVisible={!isLogined}></LoginBox>
        </div>
    )
}

export default Header;