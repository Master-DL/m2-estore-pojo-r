# estore

Projet pour l'enseignement des composants logiciels

Réponses google forms (en cours) :

https://github.com/Master-DL/m2-estore-pojo-r

BAYCHELIER Rémi PEYRICHOUX Rémy

Classes :
- Account : withdraw()
- Bank: transfert(), dépendance à Account (et jeu de données set-up dans le constructeur)
- Cart: addItems(), dépendance à Client
- Client: Jeu de données dans le constructeur et scénarios, dépendance à Store
- ItemInStock : changeQuantity, dépendance à Provider
- Order : addItem() et computeAmount(), dépendance à Client
- Provider : order()
- Store : isAvailable(), addItemToCart(), pay(), oneShotOrder(), treatOrder(), dépendance à Bank et Provider

Lecture des attributs du code, distinction des méthodes de type getter/setter aux méthodes qui font du traitement plus complexe sur les objets et qui sont pour la plupart publiques.

Voir dépendances dans la question 1

- Account : withdraw() - soustrait un montant d'un compte
- Bank: transfert() - virement d'un montant d'un compte vers un autre
- Cart: addItem() - ajout d'un produit dans le panier
- ItemInStock : changeQuantity() - changer l'inventaire d'un produit en stock
- Order : addItem() - ajout du prix d'un produit dans la commande et change l'inventaire de ce produit, computeAmount() - calculer le montant de la commande
- Provider : order() - retourne une valeur aléatoire dépendant d'une quantité
- Store : isAvailable() - retourne vrai si l'objet donné est en stock
  addItemToCart() - ajoute un produit dans le panier avec une quantité
  pay() - crée la commande, calcule son montant et effectue le virement entre les comptes
  oneShotOrder() - commande d'un seul type de produit avec une quantité

IBankService : Bank, Account
IItemService: Cart, ItemInStock, Order
ISellerService : Provider, Store

IBankService : transfert(), withdraw(), credit()
IItemService : addItem(), setQuantity(), computeAmount()
ISellerService : order(), pay()

8 (+ quelques méthodes uniques à certains services)

Je ne comprends pas la question, ce ne sont pas les mêmes services que ceux exprimés deux questions plus tôt ?