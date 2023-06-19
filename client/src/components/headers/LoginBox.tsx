import { ChangeEvent, useState } from "react";
import CryptoJS from "crypto-js";
import apis from "../../commons/apis";
import { LoginResponseInterface, ResponseResultValue } from "commons/interface";

const LoginBox: React.FC<{visiblity:boolean, setVisiblity:(input:boolean) => void}> = ({visiblity, setVisiblity}) => {

    const [id, setId] = useState('');
    const [pwd, setPwd] = useState('');

    const onIdChangeEvent  = (e: ChangeEvent<HTMLInputElement>) => { setId(e.target.value); }
    const onPwdChangeEvent = (e: ChangeEvent<HTMLInputElement>) => { setPwd(e.target.value); }

    const onBtnClickEvent  = async () => {
        const hashPwd = CryptoJS.SHA256(pwd).toString(CryptoJS.enc.Hex);
        const res: LoginResponseInterface = await apis.postLogin(id, hashPwd);

        if (res.result === ResponseResultValue.SUCCESS) {
            sessionStorage.setItem('login', res.data.name);
            setVisiblity(false);
            setId('');
            setPwd('');
            window.location.reload();
        }
    }

    return visiblity ? (
        <div className="flex flex-row ml-auto">
            <input type="text" value={id} onChange={onIdChangeEvent} placeholder="아이디" className="m-1 border-[1px] p-1 border-gray-300"/>
            <input type="password" value={pwd} onChange={onPwdChangeEvent} placeholder="비밀번호" className="m-1 p-1 border-[1px] border-gray-300"/>
            <button onClick={onBtnClickEvent} className="border-[1px] m-1 p-1 bg-gray-300">로그인</button>
        </div>
    )
    :
    (
        <div></div>
    )
}

export default LoginBox;