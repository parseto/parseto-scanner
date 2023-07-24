1. 시나리오

```js
P0.init
|> P01.ALL


{
    main : [
        BizSector::name,page,isclick,
        BizSectorMsg.BizSectorUpdate
    ],

    footer: [
        MobilePageMsg.Next 
        => MobilePageMsg.PreUpdate 
        => clickPage[P01X_GET,P01X_POST]
        

    ]

}


P01.ALL
|> P01X_GET
{
    main : [
        sampleSectorMap ::,
        
    ],

    footer: [

    ]

}
|> P01X_POST
{
    main : [
    ],

    footer: [
        

    ]

}
```
