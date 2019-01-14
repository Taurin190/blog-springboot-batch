## はじめに
アウトプットの重要性を感じ、ブログサイトを作成しました。
Qiitaやはてブを使わずに一から作成することで、一から作れるかを確かめられ、
学び直しと次の課題を考えることが出来ました。
仕事から帰ってからや休日などの時間でSpringbootのアプリをGKE上に置いて公開しました。

## 何を作ったか？
- GKE上にSpringbootのDockerコンテナをデプロイ
  - テンプレートを修正してHTML作成
  - GCP SQLを使用し、JPAでデータ読み込み
  - Springbootでデータを修正してフロントに表示
- GCE上にデータを追加するバッチを作成
  - プロフィールのデータをpropertiesファイルから読み込んで追加
  - ブログのデータをjsonから読み込んで追加

## サイトを作成してみて
### GCPでのアプリのデプロイ、各種設定
1. DockerイメージをContainer Registryに登録
1. GCP SQLにデータベース作成
1. GKEで登録したDockerイメージを選択してデプロイ

DockerイメージをContainer Registryに登録する方法は、
以下の手順を参考に行えます。
リポジトリにログインして、Dockerイメージにタグを付けてpushすれば登録できます。

登録するタグは、このように付ければできます。

    docker tag [SOURCE_IMAGE] [HOSTNAME]/[PROJECT-ID]/[IMAGE]

https://cloud.google.com/container-registry/docs/pushing-and-pulling?hl=ja


GCP SQLの登録についてもドキュメントがあり、
使用したいDatabaseを選択できます。自分はMySQL5.7を選択しました。

https://cloud.google.com/sql/docs/mysql/quickstart?hl=ja


GKEのデプロイも選択していけば、簡単に登録は出来るのですが、
SQLとの接続で注意する部分がありました。
- GKEでクラスタを作る時に、GCEのインスタンスが立ち上がりSQLへの接続権限を付与する
- Role設定をしてSQLへの権限を設定する
- SQLの権限をsecretで登録する

ただ、この辺りの情報については公式ドキュメントに非常に詳しく書かれています。
そのため、公式ドキュメントを見て、チュートリアルをこなしたり実際に触ってみるのが
理解するのに一番早いと感じました。

https://cloud.google.com/sql/docs/mysql/connect-kubernetes-engine?hl=ja

## 今後の課題
今回、簡単にアプリを作ってGCP上にデプロイしてみましたが、
以下は今後の課題としてやっていこうかと思います。
- https化と構成の変更
- 投稿部分の作成

## 最後に
簡単な参照のみのアプリですが作成し、デプロイまでの一連の流れを確認できました。
分からない部分に関しても公式のドキュメントが充実していて非常に有り難かったです。
今回はサイト自体作りましたが、中身も充実出来るようにしていこうと思います。