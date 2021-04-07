// import React from 'react';
// import axios from "axios";
//
//
// const {useState} = React;
// export const Cats = (props) => {
//
//     const [stage, setStage] = useState(0);
//
//     const {cats} = props;
//
//     const pairs = [];
//     let excluded = [];
//
//     if (cats.length >= 10) {
//         while (excluded.length !== 10) {
//             let first = Math.floor(Math.random() * 10);
//             let second = Math.floor(Math.random() * 10);
//             if (first === second) {
//                 second = Math.floor(Math.random() * 10);
//             } else if (excluded.includes(first) === false && excluded.includes(second) === false) {
//                 excluded.push(first, second);
//                 pairs.push([first, second])
//             }
//         }
//     }
//
//     const vote = (e, catId) => {
//         if (e.target.tagName !== 'DIV') {
//             e.preventDefault();
//             if (stage < cats.length / 2) {
//                 setStage(stage + 1);
//             }
//         }
//         axios.post('/vote', {catId: catId})
//             .then()
//             .catch((e) => {
//                 console.log(e);
//                 alert('Some error')
//             })
//     }
//
//     let list = ""
//     if (cats.length > 0) {
//         list = pairs[stage].map((pair, key) => {
//             return (
//                 <div className="box" key={key}>
//                     <div className="cat-box" onClick={(e) => vote(e, cats[pairs[stage][0]].id)}>
//                         <img className="cat-img" src={cats[pairs[stage][0]].imgUrl} alt=""/>
//                         <p>{cats[pairs[stage][0]].name}</p></div>
//                     <div className="cat-box" onClick={(e) => vote(e, cats[pairs[stage][1]].id)}>
//                         <img className="cat-img" src={cats[pairs[stage][1]].imgUrl} alt=""/>
//                         <p>{cats[pairs[stage][1]].name}</p></div>
//                 </div>
//             );
//         })
//     }
//     let top = '';
//     if (stage === cats.length / 2) {
//         axios.post('/top')
//             .then((r) => {
//                 top = r.data.map((cat, key) => {
//                     return (
//                         <div className="top-div">
//                             <h1>{key + 1}</h1>
//                             <img className="cat-img-top" src={cat.imgUrl} alt=""/>
//                             <p className="p-top">{cat.name}</p></div>
//                     );
//                 })
//             })
//             .catch((e) => alert('Some error'));
//     }
//
//     return (
//         <div>
//             {stage !== cats.length/2 ? <div>
//                 <div className="h1h4">
//                     <h1>Мимимиметр</h1>
//                     <h4>Кто из них мимимишнее? Кликни по фото или имени</h4>
//                 </div>
//                 {list}
//             </div>
//             :
//                 <div>
//                 <div className="h1h4">
//                     <h1>Мимимиметр</h1>
//                     <h4>Топ-10</h4>
//                 </div>
//                 {top}
//             </div>}
//         </div>
//     );
// }
//
