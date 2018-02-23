# polytech-portfolio
android訓練課題で作成したアプリです。

**課題の仕様書よりMainActivityから4機能の画面遷移し使用できるandroidアプリケーションを作りました。** 

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
