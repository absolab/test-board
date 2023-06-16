import { ChangeEvent, useState } from "react";
import CryptoJS from "crypto-js";
import apis from "../../commons/apis";

const LoginBox = () => {
    
    const [id, setId] = useState('');
    const [pwd, setPwd] = useState('');

    const onIdChangeEvent = (e: ChangeEvent<HTMLInputElement>) => {
        setId(e.target.value);
    }

    const onPwdChangeEvent = (e: ChangeEvent<HTMLInputElement>) => {
        setPwd(e.target.value);
    }

    const onBtnClickEvent = async () => {

        const hashPwd = CryptoJS.SHA256(pwd).toString(CryptoJS.enc.Hex);

        const res = await apis.postLogin(id, hashPwd);
        console.log({id: id, pwd: hashPwd})
        console.log(res);

    }

    return (
        <div className="flex flex-row border-black border-2">
            <div>
                ID
                <input type="text" value={id} onChange={onIdChangeEvent} className=" border-2 border-black"/>
            </div>
            <div className="flex">
                PW
                <input type="password" value={pwd} onChange={onPwdChangeEvent} className="border-2 border-black"/>
            </div>
            <button onClick={onBtnClickEvent} className="border-[5px]">로그인</button>
        </div>
    )
}

export default LoginBox;