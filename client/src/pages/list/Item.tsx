import { BoardInterface } from "commons/interface";
import { useNavigate } from "react-router-dom";

const Item: React.FC<{item:BoardInterface, isHeader:boolean}> = ({item, isHeader}) => {

    const navigate = useNavigate();

    const onItemClickEvent = () => {
        navigate("/detail/" + item.bid);
    }

    if (isHeader) {
        return (
            <div className="flex border-gray-300 border-b-[1px] h-10 items-center">
                <div className="w-24 text-center mx-1 font-bold">
                    {item.bid}
                </div>
                <div className="w-[512px] mx-1 text-center font-bold">
                    {item.title}
                </div>
                <div className="w-24 text-center mx-1 font-bold">
                    {item.name}
                </div>
                <div className="w-24 text-center mx-1 font-bold">
                    {item.crtnDate}
                </div>
            </div>
        )
    } else {
        return (
            <div className="flex border-gray-300 border-b-[1px] h-8 items-center cursor-pointer" onClick={onItemClickEvent}>
                <div className="w-24 text-center mx-1">
                    {item.bid}
                </div>
                <div className="w-[512px] mx-1">
                    {item.title}
                </div>
                <div className="w-24 text-center mx-1">
                    {item.name}
                </div>
                <div className="w-24 text-center mx-1">
                    {item.crtnDate}
                </div>
            </div>
        )
    }

}

export default Item;