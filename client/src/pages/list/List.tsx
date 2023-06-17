import { WriteInterface } from "commons/interface";
import { Header } from "components";
import Board from "./Board";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";

const List = () => {

    const tempData: Array<WriteInterface> = [
        {
            bid: "1",
            title: '글입니다.',
            writer: '작성자',
        },
        {
            bid: "2",
            title: '글2입니다.',
            writer: '작성자2',
        },
        {
            bid: "3",
            title: '글3입니다.',
            writer: '작성자3',
        },
    ]

    const navigate = useNavigate();

    const [isLogined, setIsLogined] = useState(false);

    useEffect(() => {
        const name = sessionStorage.getItem('login');
        if (name !== null) {
            setIsLogined(true);
        }
    }, [])

    const onWriteBtnClickEvent = () => { navigate('/write'); }

    return (
        <div className="flex flex-col">
            <Header isLogined={isLogined} setIsLogined={setIsLogined}></Header>
            <div className="flex flex-col mx-auto">
                <div className="my-24 mx-auto text-gray-600 font-bold text-4xl">게시판</div>
                <Board data={tempData}></Board>
                <button className="ml-auto bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={onWriteBtnClickEvent}>글작성</button>
            </div>
        </div>
    )
}

export default List;