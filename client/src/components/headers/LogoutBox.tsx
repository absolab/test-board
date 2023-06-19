import apis from "commons/apis";

const LogoutBox: React.FC<{visiblity:boolean, setVisiblity:(input:boolean) => void}> = ({visiblity, setVisiblity}) =>{

    // 'login' 부분 바꾸기
    const name = sessionStorage.getItem('login');

    const onBtnClickEvent = async () => {
        await apis.postLogout();
        sessionStorage.removeItem('login');
        setVisiblity(false);
        window.location.reload();
    }

    return visiblity ? (
        <div className="flex flex-row ml-auto">
            <div className="mr-5 my-auto">
                {name}님 환영합니다
            </div>
            <button onClick={onBtnClickEvent} className="border-[1px] m-1 p-1 bg-gray-300">로그아웃</button>
        </div>
    )
    :
    (
        <div></div>
    )
}

export default LogoutBox;