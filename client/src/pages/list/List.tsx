import { BoardListResponseInterface, ResponseResultValue, BoardInterface } from "commons/interface";
import { Header } from "components";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import apis from "commons/apis";
import Item from "./Item";

const List = () => {

    const navigate = useNavigate();

    const [isLogined, setIsLogined] = useState(false);
    const [listData, setListData] = useState<BoardInterface[]>([]);

    useEffect(() => {
        const name = sessionStorage.getItem('login');
        if (name !== null) { setIsLogined(true); }

        const getList = async () => {
            const res: BoardListResponseInterface = await apis.getList();
            if (res.result === ResponseResultValue.SUCCESS) {
                setListData(res.data);
            }
        }
        getList();
    }, []);

    const Items = listData.map(item => {
        return (
            <Item item={item} isHeader={false} key={item.bid}></Item>
        )
    })


    const onWriteBtnClickEvent = () => { navigate('/write'); }

    return (
        <div className="flex flex-col">
            <Header isLogined={isLogined} setIsLogined={setIsLogined}></Header>
            <div className="flex flex-col mx-auto">
                <div className="my-24 mx-auto text-gray-600 font-bold text-4xl">게시판</div>
                <div className="flex flex-col mx-auto">
                    <div className="border-t-[2px] border-lime-400">
                        <Item item={{ bid: "번호", title: "제목", name: "글쓴이", crtnDate: "작성일" }} isHeader={true}></Item>
                        {Items}
                    </div>
                    <div className="flex border-b-2 border-lime-400 justify-center">1 2 3 4 5</div>
                </div>
                { isLogined && <button className="ml-auto bg-gray-200 py-1 px-3 my-2 rounded hover:bg-gray-300" onClick={onWriteBtnClickEvent}>글작성</button> }
            </div>
        </div>
    )
}

export default List;