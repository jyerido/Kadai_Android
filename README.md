# polytech-portfolio
android訓練課題で作成したアプリです。




![screenshot_20180222-143911](https://user-images.githubusercontent.com/35995374/36580471-c41a9ba0-18ab-11e8-95c8-8da0b46d2d8f.png)
![screenshot_20180222-145349](https://user-images.githubusercontent.com/35995374/36580472-c444c722-18ab-11e8-865e-aaf408ce4cdd.png)
![screenshot_20180222-145409](https://user-images.githubusercontent.com/35995374/36580473-c46fcc92-18ab-11e8-9cce-a6d9c950948a.png)
![screenshot_20180222-145420](https://user-images.githubusercontent.com/35995374/36580474-c49507aa-18ab-11e8-84ff-a61f9eb7e3be.png)
![screenshot_20180222-145427](https://user-images.githubusercontent.com/35995374/36580475-c4b9d7c4-18ab-11e8-9687-8bee19ba3bef.png)

---
**課題の仕様書よりMainActivityから4機能の画面遷移し使用できるandroidアプリケーションを作りました。**   
 機能が4つなのでシンプルで使いやすいデザインにしました。  
ボタンは押しやすさを考えて大きめにしており、タップすると黒くなり押した感覚がでるようになっています。  
全て自分の力で制作したわけではないですが、訓練中の知識・参考書・指導員のアドバイス・WEB上の情報を元に作りました。    
環境：AndroidStudio 3.0.1    
実機テスト：Nexus7（2013）android6.0.1

---

- 課題1→UI設計

  

- 課題2→ベース用Activityの作成

  
            【要件】アプリ起動時4つのボタンをMainActivityに表示させる(背景色・センサー・サービス・ ネットワーク)
            

- 課題3→背景色の設定をするアプリケーションの作成

            【要件】 
                            1.MainActivityの背景色を設定するアプリケーションの作成
                            2.白・赤・青・緑・黄の5色を選択、[決定]ボタンの配置
                            3.選択した色はIntentに格納
                            4.SetColorActivityの[決定]ボタンとタップするとIntentに格納した色の背景色がMainActivity
                            に表示される

- 課題4→センサー(照度計)を実現するアプリケーションの作成

            【要件】
                           1.MainActivityのセンサーボタンをタップするとIlluminometerActivityが表示される
                           2.IlluminometerActivityには照度の数値と判定結果を表示する
                           3.IlluminometerActivityで戻るボタンをタップするとMainActivityが表示される

- 課題5→サービス(タイマー)Serviceコンポーネントを使用しタイマーを実現するアプリケーションの作成

           【要件】
                           1.MainActivityのサービスボタンをタップするとTimerActivityが表示される
                           2.BroadcastReceiverで残り時間データを受け取りTimerActivity中央のテキストに表示
                           3.スタートボタンを押すとTimerServiceを起動し、カウントダウンを開始
                           4.1秒経過ごとにBroadcastReceiverに残り時間データを送る
                           5.カウントダウン中にストップボタンを押すと停止
                           6.TimerActivityで戻るボタンを押すとMainActivityが表示される

- 課題6→ネットワーク  閲覧可能な適当なWebページにアクセスしHTTPレスポンスで得られたHTMLをテキストのまま表示するアプリケーション
 
             【要件】
                            1.MainActivityのネットワークボタンをタップするとNetActivityが表示される
                            2.NetActivityには適当なWebページのHTML文字列を表示させる
                            3.Webページのアドレスはプログラムのソースコードに埋め込んでもいいものとする
                            4.NetActivityで戻るボタンをタップするとMainActivityが表示される
