import { BoardListResponseInterface, ResponseResultValue, WriteInterface } from "commons/interface";
import { Header } from "components";
import Board from "./Board";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import apis from "commons/apis";

const List = () => {

    const navigate = useNavigate();

    const [isLogined, setIsLogined] = useState(false);
    const [listData, setListData] = useState<WriteInterface[]>([]);

    useEffect(() => {
        const name = sessionStorage.getItem('login');
        if (name !== null) { setIsLogined(true); }

        const getList = async () => {
            const res: BoardListResponseInterface = await apis.getList();
            if (res.result === ResponseResultValue.SUCCESS) {
                setListData(res.data);
                console.log(res.data);
            }
        }
        getList();
    }, []);

    const onWriteBtnClickEvent = () => { navigate('/write'); }

    return (
        <div className="flex flex-col">
            <Header isLogined={isLogined} setIsLogined={setIsLogined}></Header>
            <div className="flex flex-col mx-auto">
                <div className="my-24 mx-auto text-gray-600 font-bold text-4xl">게시판</div>
                <Board data={listData}></Board>
                {
                    isLogined &&
                    <button className="ml-auto bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={onWriteBtnClickEvent}>글작성</button>
                }
            </div>
        </div>
    )
}

export default List;