import { Header } from "components";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const Write = () => {

    const navigate = useNavigate();

    const [isLogined, setIsLogined] = useState(false);

    useEffect(() => {
        const name = sessionStorage.getItem('login');
        if (name !== null) {
            setIsLogined(true);
        }
    }, [])

    const WriteBtnClickEvent = () => {
        console.log("글 등록 버튼 클릭");
    }

    const ReturnBtnClickEvent = () => {
        navigate('/');
    }

    return (
        <div className="flex flex-col">
            <Header isLogined={isLogined} setIsLogined={setIsLogined}></Header>
            <div className="flex flex-col mx-auto">
                <div className="my-24 mx-auto text-gray-600 font-bold text-4xl">글작성</div>
                <input className="border-[2px] border-lime-400 w-[800px] outline-none p-1 mb-5" placeholder="제목" />
                <textarea className="border-[2px] border-lime-400 w-[800px] outline-none p-1 resize-none h-96" placeholder="내용" />
                <div className="flex mx-auto">
                    <button className="mx-1 bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={WriteBtnClickEvent}>등록</button>
                    <button className="mx-1 bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={ReturnBtnClickEvent}>취소</button>
                </div>
            </div>
        </div>
    )
}

export default Write;